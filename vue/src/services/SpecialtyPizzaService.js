import axios from "axios";

export default {
	getSpecialtyPizzas() {
		return axios.get("/specialty-pizzas");
	},
	createSpecialtyPizza(specialtyPizza) {
		return axios.post("/specialty-pizzas", specialtyPizza);
	},
	updateSpecialtyPizza(specialtyPizza) {
		return axios.put(`/specialty-pizzas/${specialtyPizza.id}`, specialtyPizza);
	},
};
