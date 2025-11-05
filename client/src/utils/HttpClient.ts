export interface HttpClient {
  get<T>(url: string): Promise<T>;
  post<T, U>(url: string, data: U): Promise<T>;
}

export class FetchHttpClient implements HttpClient {
  private readonly baseUrl: string;
  constructor(baseUrl: string = "http://localhost:8080/api") {
    this.baseUrl = baseUrl;
  }
  async get<T>(url: string): Promise<T> {
    const response = await fetch(this.baseUrl + url);
    return response.json();
  }
  async post<T, U>(url: string, data: U): Promise<T> {
    const response = await fetch(this.baseUrl + url, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });
    return response.json();
  }
}
