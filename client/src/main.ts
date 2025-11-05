import "./style.css";
import { FetchHttpClient } from "./utils/HttpClient";
import { Clients } from "./modules/clients/Clients";
const httpClient = new FetchHttpClient();

const clientsModule = new Clients(httpClient);

async function getAllClients() {
  const clients = await clientsModule.getClients();
  list.innerHTML = clients
    .map(
      (c) => `
    <div>
      <b>${c.name}</b> (${c.email}) - ${c.phone || ""}
    </div>
  `
    )
    .join("");
}
getAllClients();

const form = document.getElementById("form") as HTMLFormElement;
const list = document.getElementById("list") as HTMLDivElement;

form.addEventListener("submit", async (e) => {
  e.preventDefault();
  if (!e.target) return;
  const target = e.target as typeof e.target & {
    name: { value: string };
    email: { value: string };
    phone: { value: string };
  };
  const newClient = {
    name: target.name!.value as string,
    email: target.email!.value as string,
    phone: target.phone!.value as string,
  };
  console.log(newClient);

  await clientsModule.saveClient(newClient);
  form.reset();
  getAllClients();
});
