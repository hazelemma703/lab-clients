import { Clients } from "./Clients";

export class ClientUi {
  private app: HTMLDivElement;
  private title = document.createElement("h2") as HTMLHeadingElement;
  private registrationSection: HTMLElement;
  private stats = document.createElement("div") as HTMLDivElement;
  private clientsModule: Clients;

  private registrationList = document.createElement("ul") as HTMLUListElement;
  constructor(
    registrationSection: HTMLElement,
    clientsModule: Clients,
    app: HTMLDivElement
  ) {
    this.registrationSection = registrationSection;
    this.clientsModule = clientsModule;
    this.app = app;
    this.title.textContent = "Client Registration";
    this.title.textContent = "📋 NEW CLIENTS REGISTRATION";

    this.registrationSection.appendChild(this.buildClientForm());
    this.registrationSection.appendChild(this.title);
    this.stats.className = "mb-6 pb-4 border-b border-border";
    this.registrationSection.appendChild(this.stats);
    this.registrationList.className =
      "data-list h-[24rem] overflow-y-auto overflow-x-hidden snap-y snap-mandatory border p-4 scrollbar-thin scrollbar-thumb-rounded scrollbar-thumb-border scrollbar-track-background";
  }

  async getAllClients() {
    const clients = await this.clientsModule.getClients();
    this.registrationList.innerHTML = "";
    clients.forEach((c) => {
      const listItem = document.createElement("li") as HTMLLIElement;
      listItem.className = "data-item snap-center snap-always h-auto";
      listItem.innerHTML = `
    <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
              <span class="label-neon">Email:</span>
              <span class="value-neon block mt-1 break-all">${c.email}</span>
            </div>
            <div>
              <span class="label-neon">Name:</span>
              <span class="value-neon block mt-1 font-bold">${c.name}</span>
            </div>
            <div>
              <span class="label-neon">Phone:</span>
              <span class="value-neon block mt-1 text-xs">${c.phone}</span>
            </div>
          </div>
  `;
      this.registrationList.appendChild(listItem);
    });
    this.registrationSection.appendChild(this.registrationList);
    const divider1 = document.createElement("div");
    divider1.className = "section-divider";
    this.app.appendChild(divider1);
  }

  buildClientForm() {
    const formContainer = document.createElement("div");
    formContainer.className =
      "form-container container-neon p-6 mb-8 container mx-auto px-4";
    formContainer.innerHTML = `
      <form id="client-form" class="space-y-4 flex">
        <div class="flex flex-col gap-4 w-full mr-4">
          <input id="name" placeholder="Name" required class="input-field" />
          <input id="email" type="email" placeholder="Email" required class="input-field" />
          </div>
          <div class="flex flex-col gap-4 w-full">
            <input id="phone" placeholder="Phone" class="input-field" />
            <button class="btn w-full" type="submit">Save</button>
        </div>
      </form>
    `;
    return formContainer;
  }
  bindFormSubmit() {
    const form = document.getElementById("client-form") as HTMLFormElement;
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

      await this.clientsModule.saveClient(newClient);
      form.reset();
      this.getAllClients();
    });
  }
}
