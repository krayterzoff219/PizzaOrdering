<template>
	<div class="testimonial-carousel">
		<div
			v-for="(testimonial, index) in testimonials"
			:key="index"
			v-show="index === currentIndex"
			class="testimonial">
			<p>{{ testimonial.text }}</p>
			<p class="author">{{ testimonial.author }}</p>
		</div>
        <div class="carousel-buttons">
            <button @click="prev">Previous</button>
            <button @click="next">Next</button>
        </div>
        <!-- <section id="carousel-button">
		<button @click="prev">Previous</button>
		<button @click="next">Next</button>
        </section> -->
	</div>
</template>

<script>
export default {

	name: "Slider",

	data() {
		
		return {
			currentIndex: 0,
			testimonials: [
				{
					text: "OMG, this pizza was sooo good! I got the mushroom pizza. I added Italian sausage and the hot honey drizzle- don't sleep on the hot honey drizzle! It was such a nice addition to my pizza that I've never had before. It added a sweet spiciness to the already rich and flavorful pizza.",
					author: "Brock Lavergne",
				},
				{
					text: "The best pizza I've tried here in Texas! 10/10. The service was amazing, the cashier was friendly & gave us suggestions to our liking. Family friendly, they have games all over the establishment so you can play and hang out with your loved ones.",
					author: "Dean Mcneil",
				},
				{
					text: "This place is amazing the atmosphere always great the food is great. We love their mushroom pizza and fennel arugula salad.",
					author: "Daniel Commins",
				},
			],
			timer: null,
			
		};
	},

	mounted: function(){
		this.startSlide();
	},

	methods: {

		startSlide: function(){
			this.timer = setInterval(this.next, 4000)
		},

		prev() {
			if (this.currentIndex === 0) {
				this.currentIndex = this.testimonials.length - 1;
			} else {
				this.currentIndex--;
			}
		},
		next() {
			console.log();
			if (this.currentIndex === this.testimonials.length - 1) {
				this.currentIndex = 0;
			} else {
				this.currentIndex++;
			}
		},
	},
};
</script>

<style scoped>
.testimonial-carousel {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    padding-top: 100px;
	margin: 0 auto;
	text-align: center;
	max-width: 600px;
    min-height: 250px;
    
}

.testimoial {
	display: none;
	transition: all 0.9s ease-in;
}

.testimonial.active {
	display: block;
}

.author {
	font-style: italic;
}
.carousel-buttons {
	margin: 10px 10px 5px;
    display: flex;
    flex-grow: 1;
	align-items: flex-end;
}

button{
    display: flex;
    margin-left: 20px;
    margin-right: 30px;
    width: 80px;
    justify-content: center;
    
}

@media screen and (max-width: 820px){
    
.testimonial-carousel{
    display: flex;
    justify-content: center;
    align-items: center;
    
}

.carousel{
    display: flex;
    justify-content: center;
}


}

</style>
