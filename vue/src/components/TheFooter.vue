<template>
	<footer>
		<div id="footer-spacer"></div>
		<div id="footer-text">
			<span>UpperCrust Pizza </span>&nbsp;- Elevating your slice since 2023.
		</div>
		<div id="employees-portal-link">
			<router-link
				v-if="!$route.path.includes('employees')"
				:to="{ name: 'employee-login' }"
				>Employees</router-link
			>
		</div>
	</footer>
</template>

<script>
export default {};
</script>
<style scoped>
footer {
	display: none;
}

@media only screen and (min-width: 600px) {
	footer {
		display: block;
		border-top-left-radius: var(--section-border-radius);
		border-top-right-radius: var(--section-border-radius);
		background-color: var(--white-color);
		margin-top: auto;
		display: flex;
		align-items: center;
		font-size: 0.75rem;
		padding: 0 15px;
		width: 97%;
		font-weight: bold;
	}

	footer div#footer-text {
		text-align: center;
		padding: 10px;
	}

	footer div#footer-text span {
		color: var(--primary-color);
	}

	footer div#footer-spacer,
	footer div#employees-portal-link {
		flex-grow: 1;
		flex-shrink: 1;
		flex-basis: 4.5rem;
	}

	footer div#employees-portal-link {
		text-align: right;
	}

	footer div#employees-portal-link a {
		color: var(--secondary-color);
		text-decoration: none;
	}
}
</style>
