import React, {Component} from 'react';
import PhoneInfo from "./PhoneInfo";

class PhoneInfoList extends Component {

  static defaultProps = {
    data: []
  }

  render() {
    const {data, onRemove, onUpdate} = this.props;
    console.log("rendering list");

    // 이 방식 보다는 defaultProps 가 좋아보임
    // if (!data) return null;

    const list = data.map(
        // key를 설정해주지 않으면 렌더링할때 기존 컴포넌트를 추가 할때 새로운 컴포넌트만 추가 하는게 아니고
        // 기존 컴포넌트를 수정하고 따로 또 추가하는 방식으로 업데이트 해버림 -> 비효율
        info => (
            <PhoneInfo
                onRemove={onRemove}
                onUpdate={onUpdate}
                info={info}
                key={info.id}
            />)
    )

    return (
        <div>
          {list}
        </div>
    );
  }
}

export default PhoneInfoList;