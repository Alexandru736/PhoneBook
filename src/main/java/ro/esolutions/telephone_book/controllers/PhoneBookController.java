package ro.esolutions.telephone_book.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.esolutions.telephone_book.services.PhoneBookService;

@Controller
@RequestMapping("/pb")
@RequiredArgsConstructor
public class PhoneBookController {

    final PhoneBookService phoneBookService;

    @GetMapping("/phonebook")
    public String getAllPhoneBookEntries(Model model) {
        model.addAttribute("phoneBookEntries", phoneBookService.getAllPhoneBookEntries());
        return "homeView";
    }

    @GetMapping("/phonebook/{id}")
    public String getOnePhoneBookEntry(Model model, @PathVariable Long id) {
       model.addAttribute("phoneBookEntry", phoneBookService.getPhoneBookEntry(id));
       model.addAttribute("phoneNumbersById", phoneBookService.getPhoneNumbers(id));
       return "profileView";
    }

    @GetMapping("/phonebook/{id}/edit")
    public String editPhoneBookEntry(Model model, @PathVariable Long id) {
        model.addAttribute("phoneBookEntry", phoneBookService.getPhoneBookEntry(id));
        model.addAttribute("phoneNumbersById", phoneBookService.getPhoneNumbers(id));
        return "editView";
    }
}
