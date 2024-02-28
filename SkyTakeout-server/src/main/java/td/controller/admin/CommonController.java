package td.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import td.constant.MessageConstant;
import td.result.Result;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/admin/common")
@Tag(name = "通用接口")
public class CommonController {
    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file)  {
        log.info("文件上传:{}", file);
        //原始文件名

        try {
            String originalFilename = file.getOriginalFilename();
            int index = originalFilename.lastIndexOf(".");
            String extraName = originalFilename.substring(index);
            String newFileName = UUID.randomUUID().toString() + extraName;
            log.info("新文件名:{}",newFileName);
            file.transferTo(new File("D:\\app\\nginx-1.24.0\\html\\sky\\img\\dish\\"+newFileName));
            return Result.success("http://localhost:8090/sky/img/dish/"+newFileName);
        } catch (Exception e) {
            log.error("文件上传失败",e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
