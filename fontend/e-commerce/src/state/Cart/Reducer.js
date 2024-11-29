import {
  ADD_ITEM_TO_CART_FAILURE,
  ADD_ITEM_TO_CART_REQUEST,
  ADD_ITEM_TO_CART_SUCCESS,
  GET_CART_FAILURE,
  GET_CART_REQUEST,
  GET_CART_SUCCESS,
} from "./ActionType";

const initialState = {
  cart: null,
  loading: false,
  error: null,
  cartItems: [],
};

const cartReducer = (state = initialState, action) => {
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
      };

    case GET_CART_SUCCESS:
      return {
        ...state,
        cartItems: action.payload.cartItems,
        loading: false,
      };

    case GET_CART_FAILURE:
      return { ...state, loading: false, error: action.payload };

    default:
      return state;
  }
};
