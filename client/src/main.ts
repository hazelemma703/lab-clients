import "./style.css";
import { FetchHttpClient } from "./utils/HttpClient";
import { Clients } from "./modules/clients/Clients";
import { ClientUi } from "./modules/clients/clientUi";
import { ProductUi } from "./modules/products/productUi";
import { Products } from "./modules/products/Products";

const httpClient = new FetchHttpClient();

const clientsModule = new Clients(httpClient);
const productsModule = new Products(httpClient);

const app = document.getElementById("app") as HTMLDivElement;
app.classList.add(
  "h-[100vh]",
  "background-grid",
  "bg-background",
  "text-foreground",
  "space-y-6"
);

const header = document.createElement("header");
header.classList.add(
  "container-neon",
  "mb-8",
  "text-center",
  "container",
  "mx-auto",
  "px-4",
  "mt-8"
);
header.innerHTML = `
    <h1 class="text-4xl glow-cyan mb-2">⚡ Client and Product data Explorer</h1>
    <p class="text-muted-foreground uppercase tracking-widest text-sm">
      Manage your clients with ease! && Explore our product catalog. is your
      gateway to seamless client management and product discovery.
    </p>
  `;
app.appendChild(header);
const statusBar = document.createElement("div");
statusBar.className =
  "container-neon mb-8 flex justify-between items-center container mx-auto";
statusBar.innerHTML = `
    <div class="flex items-center gap-4">
      <span class="status-indicator"></span>
      <span class="text-primary font-mono text-sm">SISTEMA ACTIVO</span>
    </div>
    <div class="text-muted-foreground font-mono text-sm">
      <span id="timestamp"></span>
    </div>
  `;
app.appendChild(statusBar);

const dataSection = document.createElement("section");
dataSection.className =
  "grid gap-8 container mx-auto px-4 md:px-0 md:grid-cols-2 grid-cols-1";
app.appendChild(dataSection);

const clientRegistrationSection = document.createElement("article");
clientRegistrationSection.className =
  "container-neon p-6 mb-8 container mx-auto px-4";

const productRegistrationSection = document.createElement("article");
productRegistrationSection.className =
  "container-neon p-6 mb-8 container mx-auto px-4";

const clientUi = new ClientUi(clientRegistrationSection, clientsModule, app);
const productUi = new ProductUi(
  productRegistrationSection,
  productsModule,
  app
);

dataSection.appendChild(clientRegistrationSection);
dataSection.appendChild(productRegistrationSection);

app.appendChild(dataSection);

clientUi.getAllClients();
clientUi.bindFormSubmit();
productUi.getAllProducts();
productUi.bindFormSubmit();
