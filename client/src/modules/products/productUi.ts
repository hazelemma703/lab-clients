import { Products } from "./Products";

export class ProductUi {
  private app: HTMLDivElement;
  private title = document.createElement("h2") as HTMLHeadingElement;
  private registrationSection: HTMLElement;
  private stats = document.createElement("div") as HTMLDivElement;
  private productsModule: Products;

  private registrationList = document.createElement("ul") as HTMLUListElement;
  constructor(
    registrationSection: HTMLElement,
    productsModule: Products,
    app: HTMLDivElement
  ) {
    this.registrationSection = registrationSection;
    this.productsModule = productsModule;
    this.app = app;
    this.title.textContent = "Product Registration";
    this.title.textContent = "📋 NEW PRODUCT REGISTRATION";

    this.registrationSection.appendChild(this.title);
    this.stats.className = "mb-6 pb-4 border-b border-border";
    this.registrationSection.appendChild(this.stats);
    this.registrationList.className =
      "data-list h-[24rem] overflow-y-auto overflow-x-hidden snap-y snap-mandatory border p-4 scrollbar-thin scrollbar-thumb-rounded scrollbar-thumb-border scrollbar-track-background";
    this.registrationSection.appendChild(this.buildProductForm());
  }

  async getAllProducts() {
    const products = await this.productsModule.getProducts();

    this.registrationList.innerHTML = "";
    products.forEach((p) => {
      const listItem = document.createElement("li") as HTMLLIElement;
      // scroll animation
      listItem.className = "data-item snap-center snap-always h-auto";
      listItem.innerHTML = `
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
              <span class="label-neon">Name:</span>
              <span class="value-neon block mt-1 break-all">${p.name}</span>
            </div>
            <div>
              <span class="label-neon">Category:</span>
              <span class="value-neon block mt-1 font-bold">${p.category}</span>
            </div>
            <div>
              <span class="label-neon">Price:</span>
              <span class="value-neon block mt-1 text-xs">${p.price}</span>
            </div>
            <div>
              <span class="label-neon">Available:</span>
              <span class="value-neon block mt-1 break-all">${p.available}</span>
            </div>
            <div>
              <span class="label-neon">Quantity:</span>
              <span class="value-neon block mt-1 font-bold">${p.quantity}</span>
            </div>
            
            
        </div>
        <div>
            <span class="label-neon">Description:</span>
            <span class="value-neon block mt-1 text-xs">${p.description}</span>
        </div>
  `;
      this.registrationList.appendChild(listItem);
    });
    this.registrationSection.appendChild(this.registrationList);
    const divider1 = document.createElement("div");
    divider1.className = "section-divider";
    this.app.appendChild(divider1);
  }

  buildProductForm() {
    const formContainer = document.createElement("div");
    formContainer.className =
      "form-container container-neon p-6 mb-8 container mx-auto px-4";
    formContainer.innerHTML = `
      <form id="product-form" class="space-y-4 flex">
        <div class="flex flex-col gap-4 w-full mr-4">
            <input id="name" placeholder="Name" required class="input-field" />
            <input id="description" placeholder="Description" required class="input-field" />
            <input id="price" type="number" placeholder="Price" required class="input-field" />
            <input id="available" type="boolean" placeholder="Available" required class="input-field" />
        </div>
        <div class="flex flex-col gap-4 w-full">
            <input id="quantity" type="number" placeholder="Quantity" required class="input-field" />
            <input id="category" placeholder="Category" required class="input-field" />
            <button class="btn w-full" type="submit">Save</button>
        </div>
      </form>
    `;
    return formContainer;
  }
  bindFormSubmit() {
    const form = document.getElementById("product-form") as HTMLFormElement;
    form.addEventListener("submit", async (e) => {
      e.preventDefault();
      if (!e.target) return;
      const target = e.target as typeof e.target & {
        name: { value: string };
        description: { value: string };
        price: { value: string };
        available: { value: string };
        quantity: { value: string };
        category: { value: string };
      };
      const newProduct = {
        name: target.name!.value as string,
        description: target.description!.value as string,
        price: Number(target.price!.value),
        available: target.available!.value.toLowerCase() === "true",
        quantity: Number(target.quantity!.value),
        category: target.category!.value as string,
      };
      console.log(newProduct);

      await this.productsModule.saveProduct(newProduct);
      form.reset();
      this.getAllProducts();
    });
  }
}
