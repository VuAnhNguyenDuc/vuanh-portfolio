package com.vuanhnguyenduc.vuanhportfolio.config;

import com.vuanhnguyenduc.vuanhportfolio.model.User;
import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();

    User getLoggedUser();
}
