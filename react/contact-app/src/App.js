import React, {Component} from 'react';
import PhoneForm from "./components/PhoneForm";
import PhoneInfoList from "./components/PhoneInfoList";

class App extends Component {

  id = 3;

  state = {
    information: [
      {
        id: 0,
        name: '김일',
        phone: 1
      },
      {
        id: 1,
        name: '김이',
        phone: 2
      },
      {
        id: 2,
        name: '김삼',
        phone: 3
      }
    ],
    keyword: '',
  }

  handleChange = (e) => {
    this.setState({
      keyword: e.target.value
    })
  }

  handleCreate = (data) => {
    console.log(data);
    // 비구조 할당
    const {information} = this.state;

    // 아래 처럼 하고 setState 에서 넘겨주면 === 비교가 불가능해서 shouldComponentUpdate 가 작동을 못함
    // js 는 비교 연산자가 java 의 equals 가 기본
    // this.state.information.push({
    //   ...data,
    //   id: this.id++
    // })
    this.setState({
      // 불변성 때문에 배열에 변화가 생기면 새로운 배열로 만들어서 넘겨줘야함 -> push 대신 concat 사용
      information: information.concat({
        ...data,
        id: this.id++
      }),

      // Object.assign 사용해도 가능
      // information: information.concat(Object.assign({}, data, {
      //   id: this.id++
      // }))
    });
  }

  handleRemove = (id) => {
    const {information} = this.state;
    this.setState({
      // 데이터 삭제 시에는 slice or filter
      information: information.filter(info => info.id !== id)
    });
  }

  handleUpdate = (id, data) => {
    const {information} = this.state;
    this.setState({
      information: information.map(
          info => {
            if (info.id === id) {
              return {
                id,
                ...data,
              };
            }
            return info;
          }
      )
    })
  }

  render() {
    return (
        <div>
          <PhoneForm onCreate={this.handleCreate}/>
          <input
              value={this.state.keyword}
              onChange={this.handleChange}
              placeholder="검색..."
          />
          <PhoneInfoList
              data={this.state.information.filter(
                  info => info.name.indexOf(this.state.keyword) > -1
              )}
              onRemove={this.handleRemove}
              onUpdate={this.handleUpdate}
          />
        </div>
    );
  }
}

export default App;