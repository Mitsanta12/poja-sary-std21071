package com.poja.sary_std21071.mail;

import com.poja.sary_std21071.PojaGenerated;
import jakarta.mail.internet.InternetAddress;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ses.model.VerifyEmailIdentityRequest;

@Component
@AllArgsConstructor
@PojaGenerated
public class EmailAddressVerifier implements Consumer<InternetAddress> {

  private final EmailConf emailConf;

  @Override
  public void accept(InternetAddress emailAddress) {
    emailConf
        .getSesClient()
        .verifyEmailIdentity(
            VerifyEmailIdentityRequest.builder().emailAddress(emailAddress.getAddress()).build());
  }
}
