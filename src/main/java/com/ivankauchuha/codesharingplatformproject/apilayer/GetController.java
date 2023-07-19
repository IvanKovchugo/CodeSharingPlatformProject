package com.ivankauchuha.codesharingplatformproject.apilayer;

import com.ivankauchuha.codesharingplatformproject.businesslayer.SomeService;
import com.ivankauchuha.codesharingplatformproject.entities.Code;
import com.ivankauchuha.codesharingplatformproject.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class GetController {

    private final SomeService service;

    @Autowired
    public GetController(SomeService service) {
        this.service = service;
    }

    @GetMapping(value = "/code/{N}")
    public String getIndexPage(@PathVariable String N, Model model) {
        model.addAttribute("code", service.retrieveCode(N));
        return "index";
    }

    @GetMapping(value = "/api/code/{N}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Code getJsonByUuid(@PathVariable String N) {
        return service.retrieveCode(N);
    }

    @GetMapping(value = { "/code/new", "/"})
    public String getNewPage(Model model) {
        return "new";
    }

    @PostMapping(value = "/api/code/new", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> uploadNewCode(@RequestBody Code newCode) {
        service.saveCode(newCode);
        Map<String, String> response = new HashMap<>();
        response.put("uuid", newCode.getId());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/api/code/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Code> getLatestApi() {
        return service.getLatest();
    }

    @GetMapping(value = "/code/latest")
    public String getLatestPage(Model model) {
        model.addAttribute("code", service.getLatest());
        return "latest";
    }

    @GetMapping(value = "/code/find")
    private String getFindByUuidPage(Model model) {
        return "findByUuid";
    }

    @GetMapping(value = "/code/contacts")
    private String getContactsPage(Model model) {
        return "contacts";
    }

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleSnippetNotFoundException(Model model, NotFound ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
