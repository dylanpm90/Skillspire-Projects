package net.skillspire.tesla;

// POINT: The controller has no SQL and no @Transactional: it turns a request into one
//        service call. The transaction lives in the service (Worksheet Q8).
// ASK:   "Spring hands this controller a BankService. After TODO 2, is it really a BankService?"

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final BankService bank;

    public TransferController(BankService bank) {
        this.bank = bank;
        // * PREDICT: what does this line print at startup before TODO 2? After TODO 2 and a restart?
        System.out.println("  TransferController got a " + bank.getClass().getSimpleName());
    }

    // GET localhost:9090/accounts
    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return bank.getAccounts();
    }

    // GET localhost:9090/accounts/total
    @GetMapping("/accounts/total")
    public Double getTotal() {
        return bank.getTotal();
    }

    // POST localhost:9090/transfer?from=1&to=2&amount=100   (Apidog; curl as the fallback)
    // @RequestParam: the value comes from the URL's ?name=value pairs. Week 8 covers it properly.
    @PostMapping("/transfer")
    public String transfer(@RequestParam("from") long from,
                           @RequestParam("to") long to,
                           @RequestParam("amount") double amount) {
        bank.transfer(from, to, amount);
        // EXTRA SPOT THE BUG (Worksheet Q25-Q27): change  bank.transfer(  to  bank.transferFromInside(
        //   Restart, send 1500. Is the money back? Read the log: any "Creating new transaction"?
        return "Transfer complete: " + amount + " from " + from + " to " + to;
    }
}
