<template>

     <div class="social-icons">
        <font-awesome-icon icon="fa-twitter" />
        <font-awesome-icon :icon="instagramIcon" />
        <font-awesome-icon :icon="facebookIcon" />
    </div> 
</template>

  <script>

import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faTwitter, faInstagram, faFacebook } from "@fortawesome/free-brands-svg-icons";

export default{
    components: {
        FontAwesomeIcon,
    },
    data(){
        return {
            twitterIcon: faTwitter,
            instagramIcon: faInstagram,
            facebookIcon: faFacebook,
        };
    },

};

<style>



</style>


 </script>