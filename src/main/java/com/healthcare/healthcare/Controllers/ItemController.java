package com.healthcare.healthcare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare.Payloads.ResponseItem;
import com.healthcare.healthcare.Services.ItemService;
import com.healthcare.healthcare.Utils.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/createItem")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<ResponseItem>> addItemController(@RequestBody ResponseItem entity) {
        ResponseItem item = this.itemService.createItem(entity);
        return new ResponseEntity<>(new ApiResponse<>(201 , item , "Successfully added item"),HttpStatus.CREATED);
    }

    @GetMapping("/get-Item/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    public ResponseEntity<ApiResponse<ResponseItem>> getItemController(@PathVariable int id) {
        ResponseItem result = this.itemService.getItemUsingId(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , result , "Successfully fetched item"), HttpStatus.OK);
    }
    
    
}
