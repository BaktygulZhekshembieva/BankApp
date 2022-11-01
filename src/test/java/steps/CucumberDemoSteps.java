package steps;

import digitalnomads.Bank;
import digitalnomads.DemirBank;
import digitalnomads.KyrgyzstanBank;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CucumberDemoSteps {

    DemirBank atayDA;
    KyrgyzstanBank nurazizKA;
    DemirBank johnDA;
    {
        try {
            atayDA = new DemirBank(123456123456L, 123456123L);
            nurazizKA = new KyrgyzstanBank(123478523697L, 147369258L);
            johnDA = new DemirBank(123456789456L, 123369147L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Given("User is logged in to Demir account")
    public void user_is_logged_in_to_demir_account() {
        System.out.println("User is logged in");
    }

    @When("User deposit ${int} to Atay")
    public void user_deposit_$_to_atay(Integer amount) throws Exception {
        atayDA.deposit(amount);
    }

    @Then("Atay should have ${int} in balance")
    public void atay_should_have_$_in_balance(Integer expectedBalance) {
        Double x = Double.valueOf(expectedBalance);
        Assertions.assertEquals(x,atayDA.getBalance());
    }

    @When("User deposit ${int} to Nuraziz")
    public void user_deposit_$_to_nuraziz(Integer amount) throws Exception {
        nurazizKA.deposit(amount);
    }
    @Then("Nuraziz should not have ${int} in balance")
    public void nuraziz_should_not_have_$_in_balance(Integer expectedBalance){
        Double x = Double.valueOf(expectedBalance);
        Assertions.assertEquals(x,nurazizKA.getBalance());
    }

    @Given("User has {int} in the account")
    public void user_has_in_the_account(Integer balanceAmount) throws Exception {
        johnDA.deposit(balanceAmount);
    }
    @When("User deposits {int} to John Doe")
    public void user_deposits_to_john_doe(Integer amount) throws Exception {
        Bank.transferFounds(johnDA,atayDA,amount);
    }
    @Then("User should have {int}")
    public void user_should_have(Integer amount) {
        Assertions.assertEquals(Double.valueOf(amount),johnDA.getBalance());
    }
    @Then("John Doe Should not any deposits")
    public void john_doe_should_not_any_deposits() {
        System.out.println(johnDA.getBalance());
    }
}
