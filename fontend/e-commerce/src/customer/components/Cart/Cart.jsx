import React, { useEffect } from "react";
import CartItem from "./CartItem";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getCart } from "../../../state/Cart/Action";

const Cart = () => {
  const navigate = useNavigate();
  const { cart } = useSelector((store) => store);

  const dispatch = useDispatch();

  const handleCheckout = () => {
    navigate("/checkout?step=2");
  };

  useEffect(() => {
    dispatch(getCart());
  }, [cart.updateCartItem, cart.deleteCartItem]);

  console.log("cart___", cart);

  return (
    <div>
      <div className="lg:grid grid-cols-3 lg:px-16 relative">
        <div className="col-span-2">
          {cart.cartItems.map((item) => (
            <CartItem item={item} />
          ))}
        </div>

        <div className="px-5 sticky  top-0 h-[100vh] mt-5 lg:mt-0">
          <div className="border">
            <p className="uppercase font-bold opacity-60 pb-4">
              Chi Tiết Hóa Đơn
            </p>
            <hr />
            <div className="space-y-3 font-semibold mb-10">
              <div className="flex justify-between pt-3 text-black">
                <span>Price</span>
                <span>${cart.totalPrice * cart.totalItem}</span>
              </div>

              <div className="flex justify-between pt-3 ">
                <span>Discount</span>
                <span className=" text-green-600">
                  -${cart.totalDiscountedPrice}
                </span>
              </div>

              <div className="flex justify-between pt-3 ">
                <span>Delivery Charges</span>
                <span className="text-green-600">Free</span>
              </div>

              <div className="flex justify-between pt-3 ">
                <span>Total Amount</span>
                <span className="text-green-600  font-bold">
                  {cart.totalPrice * cart.totalItem - cart.totalDiscountedPrice}
                </span>
              </div>
            </div>

            <Button
              onClick={handleCheckout}
              varitant="contained"
              className="w-full mt-5 font-bold"
              sx={{
                px: "2.5rem",
                py: ".7rem",
                color: "black",
                bgcolor: "RGB(145 85 253)",
              }}
            >
              Thanh Toan
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Cart;
