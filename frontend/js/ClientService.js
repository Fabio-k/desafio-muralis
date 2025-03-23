export default class ClientService {
  static baseurl = "http://localhost:8080/clientes";
  static async getClientsFetch(name = "", cpf = "") {
    return fetch(
      this.baseurl +
        `?nome=${encodeURIComponent(name)}&cpf=${encodeURIComponent(cpf)}`
    ).then((response) => {
      if (!response.ok) {
        throw new Error("Erro ao buscar os dados " + response.status);
      }
      return response.json();
    });
  }

  static async findClientById(clientId) {
    return fetch(this.baseurl + `/${clientId}`).then((response) => {
      if (!response.ok) {
        throw new Error("Erro ao buscar os dados " + response.status);
      }
      return response.json();
    });
  }

  static async deleteClient(clientId) {
    return fetch(this.baseurl + `/remove/${clientId}`, {
      method: "DELETE",
    }).then((response) => {
      if (response.status == 204) {
        window.location.href = "index.html";
      }
    });
  }

  static async editClient(clientId, clientData) {
    const response = await fetch(this.baseurl + `/update/${clientId}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(clientData),
    });

    const result = await response.json();

    if (response.ok) {
      window.location.href = `show.html?id=${result.id}`;
      return null;
    }

    return result;
  }

  static async saveClient(clientData) {
    const response = await fetch(this.baseurl + "/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(clientData),
    });
    const result = await response.json();

    if (response.ok) {
      window.location.href = `show.html?id=${result.id}`;
      return null;
    }

    return result;
  }
}
