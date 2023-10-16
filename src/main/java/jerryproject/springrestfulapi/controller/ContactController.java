package jerryproject.springrestfulapi.controller;

import jerryproject.springrestfulapi.entity.User;
import jerryproject.springrestfulapi.model.ContactResponse;
import jerryproject.springrestfulapi.model.CreateContactRequest;
import jerryproject.springrestfulapi.model.WebResponse;
import jerryproject.springrestfulapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.create(user, request);

        return WebResponse.<ContactResponse>builder().data(contactResponse).build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> get(User user, @PathVariable("contactId") String contactId) {
        ContactResponse contactResponse = contactService.get(user, contactId);

        return WebResponse.<ContactResponse>builder().data(contactResponse).build();
    }

}
