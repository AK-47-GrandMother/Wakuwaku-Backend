package dev.backend.wakuwaku.global.infra.oauth.oauthcode;

import dev.backend.wakuwaku.domain.oauth.dto.OauthServerType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Component
public class OauthCodeRequestUrlProviderComposite {

    private final Map<OauthServerType, OauthCodeRequestUrlProvider> mapping;

    public OauthCodeRequestUrlProviderComposite(Set<OauthCodeRequestUrlProvider> providers) {
        mapping = providers.stream()
                .collect(toMap(
                        OauthCodeRequestUrlProvider::supportServer,
                        identity()
                ));
    }

    public String provide(OauthServerType oauthServerType) {
        return getProvider(oauthServerType).provide();
    }

    private OauthCodeRequestUrlProvider getProvider(OauthServerType oauthServerType) {
        return Optional.ofNullable(mapping.get(oauthServerType))
                .orElseThrow(() -> new RuntimeException("지원하지 않는 소셜 로그인 타입입니다."));
    }
}