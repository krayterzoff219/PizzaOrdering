import axios from "axios";

export default {
	update(user) {
		return axios.put("/userdata", user);
	},
};
