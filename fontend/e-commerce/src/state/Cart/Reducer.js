import {
  ADD_ITEM_TO_CART_FAILURE,
  ADD_ITEM_TO_CART_REQUEST,
  ADD_ITEM_TO_CART_SUCCESS,
  GET_CART_FAILURE,
  GET_CART_REQUEST,
  GET_CART_SUCCESS,
  REMOVE_CART_ITEM_FAILURE,
  REMOVE_CART_ITEM_REQUEST,
  REMOVE_CART_ITEM_SUCCESS,
  UPDATE_CART_ITEM_FAILURE,
  UPDATE_CART_ITEM_REQUEST,
  UPDATE_CART_ITEM_SUCCESS,
} from "./ActionType";

const initialState = {
  cart: null,
  cartItems: [],
  totalPrice: 0,
  totalItem: 0,
  totalDiscountedPrice: 0,
  discounte: 0,
  loading: false,
  error: null,
};

export const cartReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_ITEM_TO_CART_REQUEST:
      return { ...state, loading: true, error: null };

    case ADD_ITEM_TO_CART_SUCCESS:
      return {
        ...state,
        cartItems: [...state.cartItems, action.payload.cartItems],
        loading: false,
      };

    case ADD_ITEM_TO_CART_FAILURE:
      return { ...state, loading: false, error: action.payload };

    case GET_CART_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
      };

    case GET_CART_SUCCESS:
      return {
        ...state,
        cartItems: action.payload.cartItems,
        totalPrice: action.payload.totalPrice,
        totalItem: action.payload.totalItem,
        totalDiscountedPrice: action.payload.totalDiscountedPrice,
        discounte: action.payload.discounte,
        loading: false,
      };

    case GET_CART_FAILURE:
      return { ...state, loading: false, error: action.payload };
    case REMOVE_CART_ITEM_REQUEST:
    case UPDATE_CART_ITEM_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
      };
    case REMOVE_CART_ITEM_SUCCESS:
      return {
        ...state,
        deleteCartItem: action.payload,
        loading: false,
      };
    case UPDATE_CART_ITEM_SUCCESS:
      return {
        ...state,
        updateCartItem: action.payload,
        loading: false,
      };
    case REMOVE_CART_ITEM_FAILURE:
    case UPDATE_CART_ITEM_FAILURE:
      return {
        ...state,
        error: action.payload,
        loading: false,
      };
    default:
      return state;
  }
};
