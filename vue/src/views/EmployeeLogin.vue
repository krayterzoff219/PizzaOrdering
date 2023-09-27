<template>
	<section
		id="employee-login"
		class="employee-section">
		<horizontal-hero></horizontal-hero>
		<form @submit.prevent="login">
			<h1>Please Sign In</h1>
			<an-alert
				v-if="invalidCredentials"
				message="Invalid username and password!"></an-alert>
			<an-alert
				v-if="this.$route.query.registration"
				message="Thank you for registering, please sign in."></an-alert>
			<!-- <div
				role="alert"
				v-if="invalidCredentials">
				Invalid username and password!
			</div>
			<div
				role="alert"
				v-if="this.$route.query.registration">
				Thank you for registering, please sign in.
			</div> -->

			<user-input
				label="Username: "
				inputId="employee-login-username-input"
				inputType="text"
				v-model="user.username"
				:isAutofocus="true"
				:isRequired="true"></user-input>

			<user-input
				label="Password: "
				inputId="employee-login-password-input"
				inputType="password"
				v-model="user.password"
				:isRequired="true"></user-input>

			<small-button
				buttonText="Sign in"
				buttonType="submit"></small-button>
		</form>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import SmallButton from "../components/SmallButton.vue";
import UserInput from "../components/UserInput.vue";
import authService from "../services/AuthService";

export default {
	name: "login",
	components: { UserInput, SmallButton, HorizontalHero, AnAlert },
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
		login() {
			authService
				.login(this.user)
				.then((response) => {
					if (response.status == 200) {
						this.$store.commit("SET_AUTH_TOKEN", response.data.token);
						this.$store.commit("SET_USER", response.data.user);
						this.$router.push({ name: "pending-orders" });
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
	beforeCreate() {
		if (this.$store.state.token) {
			this.$router.push({ name: "pending-orders" });
		}
	},
};
</script>

<style scoped></style>
