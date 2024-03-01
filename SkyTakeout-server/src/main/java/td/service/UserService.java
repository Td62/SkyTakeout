package td.service;

import org.springframework.stereotype.Service;
import td.dto.UserLoginDTO;
import td.entity.User;

@Service
public interface UserService {

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
