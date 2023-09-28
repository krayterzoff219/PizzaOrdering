import axios from "axios";

export default {
	// getSpecialtyPizzas() {
	// 	return axios.get("/menuitems/specialty");
	// },
	createSpecialtyPizza(specialtyPizza) {
		return axios.post("/menuitems/specialty", specialtyPizza);
	},
	updateSpecialtyPizza(specialtyPizza) {
		return axios.put(
			`/menuitems/specialty/${specialtyPizza.id}`,
			specialtyPizza
		);
	},
};
