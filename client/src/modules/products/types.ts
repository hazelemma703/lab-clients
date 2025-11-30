export interface Product {
  id?: number;
  name: string;
  description: string;
  price: number;
  available: boolean;
  quantity: number;
  category: string;
}

export type PostProductType = Omit<Product, "id">;
