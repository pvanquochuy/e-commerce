import { api } from "../../config/apiConfig";
import {
  FIND_PRODUCTS_FAILURE,
  FIND_PRODUCTS_REQUEST,
  FIND_PRODUCTS_SUCCESS,
} from "./ActionType";

export const findProducts = (reqData) => (dispatch) => {
  dispatch({ type: FIND_PRODUCTS_REQUEST });

  const [
    colors,
    sizes,
    minPrices,
    maxPrice,
    minDiscount,
    category,
    stock,
    sort,
    pageNumber,
    pageSize,
  ] = reqData;
  try {
    const { data } =
      api.get(`/api/products/color=${colors}&size=${sizes}&minPrice=&${minPrices}&
        maxPrice=${maxPrice}&minDiscount=${minDiscount}&category=${category}&stock=${stock}&sort=${sort}&pageNumber=${pageNumber}&pageSize=${pageSize}`);

    dispatch({ type: FIND_PRODUCTS_SUCCESS, payload: data });
  } catch (error) {
    dispatch({ type: FIND_PRODUCTS_FAILURE, payload: error.message });
  }
};
