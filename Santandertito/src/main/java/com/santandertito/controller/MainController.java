package com.santandertito.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.santandertito.exceptions.BankTransactionException;
import com.santandertito.form.SendAbonoForm;
import com.santandertito.form.SendCargoForm;
import com.santandertito.form.SendMoneyForm;
import com.santandertito.model.BankAccountInfo;
import com.santandertito.repo.BankAccountDAO;


@Controller
public class MainController {
 
    @Autowired
    private BankAccountDAO bankAccountDAO;
 
    @GetMapping(value="/",  produces=MediaType.APPLICATION_JSON_VALUE)
	 public String showBankAccounts(Model model) {
        List<BankAccountInfo> list = bankAccountDAO.listBankAccountInfo();
 
        model.addAttribute("accountInfos", list);
 
        return "accountsPage";
    }
 
    @GetMapping(value="/sendMoney",  produces=MediaType.APPLICATION_JSON_VALUE)
	public String viewSendMoneyPage(Model model) {
 
        SendMoneyForm form = new SendMoneyForm(1, 2, 700d);
 
        model.addAttribute("sendMoneyForm", form);
 
        return "sendMoneyPage";
    }
 
  
    @PostMapping(value="/sendMoney",  produces=MediaType.APPLICATION_JSON_VALUE)
	public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {
 
        System.out.println("Send Money: " + sendMoneyForm.getAmount());
 
        try {
            bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
                    sendMoneyForm.getToAccountId(), //
                    sendMoneyForm.getAmount());
        } catch (BankTransactionException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/sendMoneyPage";
        }
        return "redirect:/";
    }
    
    
    ////////////////////
    
    @GetMapping(value="/sendCargo",  produces=MediaType.APPLICATION_JSON_VALUE)
	public String viewSendCargoPage(Model model) {
 
        SendCargoForm form = new SendCargoForm(1, 700d);
 
        model.addAttribute("sendCargoForm", form);
 
        return "sendCargoPage";
    }
 
  
    @PostMapping(value="/sendCargo",  produces=MediaType.APPLICATION_JSON_VALUE)
	public String processCargoMoney(Model model, SendCargoForm sendCargoForm) {
 
        System.out.println("Se envio : " + sendCargoForm.getAmount());
 
        try {
            bankAccountDAO.sendCargo(sendCargoForm.getFromAccountId(), //
                                     sendCargoForm.getAmount());
        } catch (BankTransactionException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/sendCargoPage";
        }
        return "redirect:/";
    }
    
////////////////////
    
@GetMapping(value="/sendAbono",  produces=MediaType.APPLICATION_JSON_VALUE)
public String viewSendAbonoPage(Model model) {

SendAbonoForm form = new SendAbonoForm(1, 700d);

model.addAttribute("sendAbonoForm", form);

return "sendAbonoPage";
}


@PostMapping(value="/sendAbono",  produces=MediaType.APPLICATION_JSON_VALUE)
public String processAbonoMoney(Model model, SendAbonoForm sendAbonoForm) {

System.out.println("Se envio : " + sendAbonoForm.getAmount());

try {
bankAccountDAO.sendAbono(sendAbonoForm.getToAccountId(), //     
      sendAbonoForm.getAmount());
} catch (BankTransactionException e) {
model.addAttribute("errorMessage", "Error: " + e.getMessage());
return "/sendAbonoPage";
}
return "redirect:/";
}
 
}