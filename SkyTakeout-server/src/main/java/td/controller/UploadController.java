package td.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import td.result.Result;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
@Tag(name = "文件上传接口")
public class UploadController {
    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传:{}", file);
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String extraName = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extraName;
        log.info("新文件名:{}",newFileName);
        file.transferTo(new File("D:\\downloads\\"+newFileName));
        return Result.success();
    }
}
