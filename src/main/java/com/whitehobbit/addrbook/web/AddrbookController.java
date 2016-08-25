package com.whitehobbit.Addrbook.web;

import com.whitehobbit.Addrbook.domain.Addrbook;
import com.whitehobbit.Addrbook.service.AddrbookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by whitehobbit on 2016. 8. 25..
 */
@Controller
@RequestMapping("/addrbook")
public class AddrbookController {
    @Autowired
    AddrbookService addrbookService;

    @ModelAttribute
    AddrbookForm setUpForm() { return new AddrbookForm(); }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Addrbook> addrbooks = addrbookService.findAll();
        model.addAttribute("addrbooks", addrbooks);
        return "addrbook/list";
    }

    @RequestMapping("/form")
    String form(Model model) {
        return "addrbook/form";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated AddrbookForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
        Addrbook addrbook = new Addrbook();
        BeanUtils.copyProperties(form, addrbook);
        addrbookService.create(addrbook);
        return "redirect:/addrbook";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, AddrbookForm form) {
        Addrbook addrbook = addrbookService.findOne(id);
        BeanUtils.copyProperties(addrbook, form);
        return "addrbook/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated AddrbookForm form, BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        Addrbook addrbook = new Addrbook();
        BeanUtils.copyProperties(form, addrbook);
        addrbook.setAb_id(id);
        addrbookService.update(addrbook);
        return "redirect:/addrbook";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() { return "redirect:/addrbook"; }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        addrbookService.delete(id);
        return "redirect:/addrbook";
    }
}
