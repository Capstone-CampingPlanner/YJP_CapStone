<template>
  <div>
  {{contentId}}
  </div>
</template>

<script>
import data from '@/data';

export default {
  name: 'CommentList',
  props: {
    contentId: Number,
  },
  data() {
    return{
      comments: data.Comment.filter(item => item.writer_code===this.List.mid.mid)
    }
  }
}
</script>