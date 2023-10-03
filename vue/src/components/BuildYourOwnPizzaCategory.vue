<template>


        <div class="buildYourOwnPizza">

			<h2>Choose your {{optionsCategory}}:</h2>
                <form>
                    <div v-for="option of $store.state[optionsCategory]"
                        :key="option.id">
                        <input :type="isMultiple ? 'checkbox' : 'radio'"
                        :name="optionsCategory"
                        :value="option.id"
                        v-model="userOption">

                        <label
                        :for="option.name">{{option.name}}</label>




                    </div>
                </form>
		</div>


</template>

<script>



export default {

props: [
    "optionsCategory",
    "isMultiple"
],

data(){
    return {
        userOption: []
    }
},

watch: {
		userOption(newValue) {
			// Emit an input event to the parent to update the parent component's value
			this.$emit("input", newValue);
		},
	},

}
</script>


<style scoped>

</style>