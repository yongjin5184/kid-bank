package com.learnwithted.kidbank.adapter.sms;

import com.learnwithted.kidbank.domain.BalanceChangedNotifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"feature.notify.balance.change=false"})
public class BalanceNotifierFeatureDisabledIntegrationTest {

  @Autowired
  BalanceChangedNotifier balanceChangedNotifier;

  @Test
  public void balanceChangeNotifiedShouldNotBeTheRealNotifier() throws Exception {
    assertThat(balanceChangedNotifier)
        .isNotInstanceOf(TextMessageBalanceChangedNotifier.class);
  }

}
