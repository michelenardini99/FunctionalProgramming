import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    void init(){
        accountHolder = new AccountHolder("Michele", "Nardini", 0);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0);        
    }

    @Test
    void testInitialBalance(){
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testBankAccountHolder(){
        assertEquals(accountHolder, bankAccountWithAtm.getHolder());
    }

    @Test
    void testDepositWithAtm(){
        bankAccountWithAtm.deposit(0, 100);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositWithAtmWrongId(){
        bankAccountWithAtm.deposit(1, 100);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositWithAtmNegativeAmount(){
        bankAccountWithAtm.deposit(0, -100);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtm(){
        bankAccountWithAtm.deposit(0, 100);
        bankAccountWithAtm.withdraw(0, 30);
        assertEquals(68, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtmWrongId(){
        bankAccountWithAtm.deposit(0, 100);
        bankAccountWithAtm.withdraw(1, 30);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtmAmountHigherThanBalance(){
        bankAccountWithAtm.deposit(0, 100);
        bankAccountWithAtm.withdraw(0, 150);
        assertEquals(99, bankAccountWithAtm.getBalance());
    }

}
