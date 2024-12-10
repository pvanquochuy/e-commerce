package com.pvanquochuy.ecommerce.controller;

import com.pvanquochuy.ecommerce.exception.CartItemException;
import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.CartItem;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.request.AddItemRequest;
import com.pvanquochuy.ecommerce.response.ApiResponse;
import com.pvanquochuy.ecommerce.service.CartItemService;
import com.pvanquochuy.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartIem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
    @Operation(description = "Remove cart item from cart")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Delete item")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);

        ApiResponse res = new ApiResponse();
        res.setMessage("item deleted successfully");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{cartItemId}")
    @Operation(description = "update item to cart")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem, @PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
        User user = userService.findUserProfileByJwt(jwt);

        CartItem updateCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);

        return new ResponseEntity<>(updateCartItem, HttpStatus.OK);
    }
}
