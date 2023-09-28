import axios from "axios";
import store from "../store/index.js";

export default {
	getMenuItems() {
		return axios.get("/menu").then((res) => {
			if (res.status === 200) {
				const commitLoadPizzaOptionsMutation = (
					optionCategory,
					optionsArray
				) => {
					store.commit(
						`LOAD_${optionCategory.toUpperCase()}`,
						optionsArray.map((option) => {
							const { id, price, name, available } = option;
							return {
								id,
								price,
								name,
								isAvailable: available,
							};
						})
					);
				};

				const { sauces, sizes, toppings, crusts } = res.data;
				commitLoadPizzaOptionsMutation("toppings", toppings);
				commitLoadPizzaOptionsMutation("sizes", sizes);
				commitLoadPizzaOptionsMutation("crusts", crusts);
				commitLoadPizzaOptionsMutation("sauces", sauces);
			}
		});
	},
};
