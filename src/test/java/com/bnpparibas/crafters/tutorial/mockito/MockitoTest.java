package com.bnpparibas.crafters.tutorial.mockito;

import com.bnpparibas.crafters.tutorial.Given;
import com.bnpparibas.crafters.tutorial.assertj.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.verification.VerificationMode;

import static com.bnpparibas.crafters.tutorial.Given.theCustomerWithId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MockitoTest {
    @Rule
    public MockitoRule mockingRules = MockitoJUnit.rule();

    @Mock
    DataPersistence dep;
    @Spy
    DataSource pkGenerator;

    @Captor
    ArgumentCaptor<Customer> customers;

    @InjectMocks
    Service toBeTested;

    @Test
    public void should_see_external_side_effects() {
        doReturn(256, 257).when(dep).publish(customers.capture());
        int customerCount = toBeTested.saveCustomers(
                Given.theCustomerWithName("Tom"),
                theCustomerWithId(42),
                Given.theCustomerWithName("Matt")
        );
        assertThat(customerCount).isEqualTo(3);
        verify(pkGenerator, times(2)).getNextCustomerPk();
        assertThat(customers.getAllValues())
                .contains(theCustomerWithId(42))
                .extracting("firstName")
                .containsSubsequence("Tom", "Matt");
    }

}
