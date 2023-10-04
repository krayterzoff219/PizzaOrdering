import axios from "axios";

export default {
	createSpecialtyPizza(specialtyPizza) {
		return axios.post("/menuitems/specialty", specialtyPizza);
	},
	updateSpecialtyPizza(specialtyPizza) {
		return axios.put(`/menuitems`, specialtyPizza);
	},
};
