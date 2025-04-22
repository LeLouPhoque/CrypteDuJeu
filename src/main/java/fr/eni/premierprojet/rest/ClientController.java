package fr.eni.premierprojet.rest;

import fr.eni.premierprojet.bll.services.ClientService;
import fr.eni.premierprojet.bo.Client;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.insert(client);
    }
}
