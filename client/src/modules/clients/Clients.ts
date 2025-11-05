import type { Client, PostClientType } from "./types";
import type { HttpClient } from "../../utils/HttpClient";

export class Clients {
  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  async getClients() {
    return this.httpClient.get<Client[]>("/clients");
  }
  async saveClient(client: PostClientType) {
    return this.httpClient.post<Client, PostClientType>("/clients", client);
  }
}
