package jerryproject.springrestfulapi.controller;

import jerryproject.springrestfulapi.model.LoginUserRequest;
import jerryproject.springrestfulapi.model.TokenResponse;
import jerryproject.springrestfulapi.model.WebResponse;
import jerryproject.springrestfulapi.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;

    @PostMapping(
            path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TokenResponse> login(@RequestBody LoginUserRequest request) {
        TokenResponse tokenResponse = authService.login(request);

        return WebResponse.<TokenResponse>builder().data(tokenResponse).build();
    }

}
