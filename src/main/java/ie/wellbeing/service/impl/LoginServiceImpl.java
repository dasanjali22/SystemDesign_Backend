package ie.wellbeing.service.impl;


import ie.wellbeing.model.LoginUser;
import ie.wellbeing.model.dao.LoginUserDao;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginUserDao loginUserDao;


    public void loginUser(LoginRequest loginRequest, String siteURL) throws IllegalStateException {
        String tempEmailId = loginRequest.getuEmail();
        String tempPassword = loginRequest.getuConfirmPassword();
        LoginUser loginUserObj = new LoginUser(tempEmailId, tempPassword);

        if (loginUserObj.getEmail() != null && loginUserObj.getConfirmPassword() != null) {
            LoginUser loginUser = loginUserDao.findByEmail(loginRequest.getuEmail());
            if (loginRequest.getuEmail() == loginUser.getEmail()) {
                System.out.println("Success");
            } else {
                throw new IllegalStateException("Bad Credentials");
            }
        }
    }
}
