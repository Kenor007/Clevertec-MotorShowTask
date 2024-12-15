package ru.clevertec.motor_show.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.motor_show.dto.ClientRequestDto;
import ru.clevertec.motor_show.dto.ClientResponseDto;
import ru.clevertec.motor_show.service.ClientService;

import java.util.HashMap;
import java.util.Map;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.POSITIVE_ID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto creatClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        log.debug("Creating client: {}", clientRequestDto);
        return clientService.createClient(clientRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable @Positive(message = POSITIVE_ID) Long id) {
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateClient(@PathVariable Long id,
                                                            @Validated @RequestBody ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.updateClient(clientRequestDto, id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Client successfully updated.");
        response.put("updatedClient", clientResponseDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{clientId}/car/{carId}")
    public ResponseEntity<String> buyCar(@PathVariable Long clientId,
                                         @PathVariable Long carId) {
        clientService.buyCar(clientId, carId);
        return ResponseEntity.ok("Car is bought successfully!");
    }
}
