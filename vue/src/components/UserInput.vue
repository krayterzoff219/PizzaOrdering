<template>
    <div>
        <label :for="inputId">{{label}}</label>
        <input type="text" :id="inputId"/>
    </div>
</template>

<script>

export default{

    props:[
        "label", "inputId",
        "bindingElement",
    ]

   

}

</script>
