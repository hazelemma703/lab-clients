import type { PostProductType, Product } from "./types";
import type { HttpClient } from "../../utils/HttpClient";

export class Products {
  private httpClient: HttpClient;
  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  async getProducts() {
    return this.httpClient.get<Product[]>("/products");
  }

  async saveProduct(product: PostProductType) {
    return this.httpClient.post<Product, PostProductType>("/products", product);
  }
}
