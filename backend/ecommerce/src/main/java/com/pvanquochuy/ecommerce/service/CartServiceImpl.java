package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.CartItemException;
import com.pvanquochuy.ecommerce.exception.ProductException;
import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.Cart;
import com.pvanquochuy.ecommerce.model.CartItem;
import com.pvanquochuy.ecommerce.model.Product;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.repository.CartRepository;
import com.pvanquochuy.ecommerce.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException, CartItemException, UserException {
        Cart cart = cartRepository.findByUserId(userId);

        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent = cartItemService.isCarttemExist(cart, product, req.getSize(), userId);

        if (isPresent == null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setDiscountedPrice(req.getDiscountedPrice());
            cartItem.setUserId(userId);

            int price = req.getQuantity() * product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());

            cartItem.setCart(cart);

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
            cartRepository.save(cart);
        } else {
            int newQuantity = isPresent.getQuantity() + req.getQuantity(); // Tăng số lượng
            isPresent.setQuantity(newQuantity);

            int price = newQuantity * product.getDiscountedPrice();
            isPresent.setPrice(price);

            isPresent.setDiscountedPrice(newQuantity * product.getDiscountedPrice());

            cartItemService.updateCartItem(userId, isPresent.getId(), isPresent);
        }

        return "Item added to cart";
    }

    @Override
    public Cart findUsercart(Long userId) {

        Cart cart = cartRepository.findByUserId(userId);

        if (cart == null){
            throw new RuntimeException("Cart not found for user id: " + userId);
        }

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem= 0;

        for(CartItem cartItem : cart.getCartItems()){
            totalPrice = totalPrice + cartItem.getPrice();
            totalDiscountedPrice = totalDiscountedPrice + cartItem.getDiscountedPrice();
            totalItem = totalItem +  cartItem.getQuantity();
        }
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        cart.setTotalPrice(totalPrice);
        cart.setDiscounte(totalPrice-totalDiscountedPrice);

        return cartRepository.save(cart);
    }
}
