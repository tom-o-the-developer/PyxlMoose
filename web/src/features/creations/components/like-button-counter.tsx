import { useState } from "react"
import { useLikeButton } from "../hooks/use-like-button"
import { LikeButtonIconProps } from "./like-button-icon"

interface LikeButtonCounterProps extends LikeButtonIconProps {
  initialLikeCount: number
}

export default function LikeButtonCounter({
  onLike,
  onUnlike,
  initialValue,
  color,
  initialLikeCount,
  ...chakraProps
}: LikeButtonCounterProps) {
  const { isLiked, toggleLike } = useLikeButton({
    initialValue,
    onLike: () => {
      setLikeCount((curLikeCount) => curLikeCount + 1)
      onLike()
    },
    onUnlike: () => {
      setLikeCount((curLikeCount) => curLikeCount - 1)
      onUnlike()
    },
  })
  const [likeCount, setLikeCount] = useState(initialLikeCount)

  return (
    // <OutlineButton
    //   // leftIcon={
    //   //   isLiked ? <MdFavorite size={20} /> : <MdFavoriteBorder size={20} />
    //   // }
    //   onClick={toggleLike}
    //   color={color}
    //   {...chakraProps}
    // >
    //   {likeCount}
    // </OutlineButton>
  )
}
