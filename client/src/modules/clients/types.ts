export interface Client {
  id?: number;
  name: string;
  email: string;
  phone: string;
}

export type PostClientType = Omit<Client, "id">;
