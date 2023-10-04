<template>
	<form @submit.prevent="login">
		<h1>Please Sign In</h1>
		<an-alert
			v-if="invalidCredentials"
			message="Invalid username and password!"
			id="customer-login-error-message"></an-alert
		><user-input
			label="Username: "
			inputId="customer-login-username-input"
			inputType="text"
			v-model="user.username"
			:isRequired="true" />
		<user-input
			label="Password: "
			inputId="customer-login-password-input"
			inputType="password"
			v-model="user.password"
			:isRequired="true" />
		<small-button
			buttonType="submit"
			buttonText="Sign In"
			:shouldStopPropagation="true" />
		<p @click="(event) => event.stopPropagation()">
			Don't have an account? &nbsp;<span
				class="jump"
				@click="
					(event) => {
						event.stopPropagation();
						sendUserToRegister();
					}
				"
				>Register</span
			>
		</p>
	</form>
</template>

<script>
import SmallButton from "./SmallButton.vue";
import UserInput from "./UserInput.vue";
import authService from "../services/AuthService";
import AnAlert from "../components/AnAlert.vue";

export default {
	name: "customer-login",
	components: { UserInput, SmallButton, AnAlert },
	data() {
		return {
			user: {
				username: "",
				password: "",
			},
			invalidCredentials: false,
		};
	},
	methods: {
		sendUserToRegister() {
			this.$store.dispatch("switchCustomerBetweenLoginAndRegisterDropDown");
		},
		login() {
			authService
				.login(this.user)
				.then((response) => {
					if (response.status == 200) {
						let user = {
							...response.data.user,
							userData: response.data.userData,
						};
						this.$store.commit("SET_AUTH_TOKEN", response.data.token);
						this.$store.commit("SET_USER", user);
						this.$store.dispatch("hideDropDownMenu");
					}
				})
				.catch((error) => {
					const response = error.response;

					if (response.status === 401) {
						this.invalidCredentials = true;
					}
				});
		},
	},
};
</script>

<style>
#customer-login-error-message {
	font-weight: bold;
	text-align: center;
}
</style>

<style scoped>
form {
	padding: 50px 25px;
	margin: 0 auto;
	max-width: 20rem;
}

form h1 {
	text-align: center;
	margin-bottom: 1.5rem;
}

form button {
	margin-right: auto;
	margin-left: auto;
	display: block;
	box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Subtle box shadow */
}

form div.form-input-group {
	margin-bottom: 0;
	padding-bottom: 1.5rem;
}

p {
	text-align: center;
	padding-top: 1.5rem;
	cursor: default;
	display: inline-block;
}

p span {
	cursor: pointer;
	text-decoration: underline;
	color: var(--secondary-color);
	display: inline-block;
}

@media (hover: hover) {
	form button:hover {
		box-shadow: 0px 6px 8px rgba(0, 0, 0, 0.2);
	}
}
</style>
