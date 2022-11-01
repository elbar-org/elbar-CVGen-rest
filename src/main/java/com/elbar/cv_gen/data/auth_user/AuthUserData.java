package com.elbar.cv_gen.data.auth_user;

import com.elbar.cv_gen.repository.auth.auth_user.AuthUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class AuthUserData implements CommandLineRunner {

    private final AuthUserRepository repository;

    public AuthUserData(AuthUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*PasswordEncoderConfigurer encoderConfigurer = new PasswordEncoderConfigurer();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<AuthUserEntity>> reference = new TypeReference<>() {
        };

        InputStream inputStream = getClass().getResourceAsStream("/data/AUTH_USER_MOCK_DATA.json");
        List<AuthUserEntity> list = objectMapper.readValue(inputStream, reference);

        list.forEach((user) -> {
            user.setPassword(encoderConfigurer.encoder().encode(user.getPassword()));
            user.setStatus(StatusEnum.findAny());
            user.setRole(RolesEnum.findAny());
            user.setLanguage(LanguagesEnum.findAny());
            repository.save(user);
        });

        log.info(">>>>>>> " + list.size() + " Users Saved!");*/

        // need to run once!
    }


}
