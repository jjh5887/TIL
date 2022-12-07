import React, {Component} from 'react';

class PhoneForm extends Component {
  // 포커스용
  // input = null;

  // 포커스 리액트 최신버전
  input = React.createRef();

  state = {
    name: '',
    phone: '',
  };

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value
    });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.onCreate(this.state);
    this.setState({
      name: '',
      phone: '',
    });

    // this.input.focus();
    // 포커스 리액트 최신버전
    this.input.current.focus();
  }

  render() {
    return (
        <div>
          <form onSubmit={this.handleSubmit}>
            <input
                name="name"
                placeholder="이름"
                onChange={this.handleChange}
                value={this.state.name}
                // 포커스
                // ref={ref => this.input = ref}
                ref={this.input}
            />
            <input
                name="phone"
                placeholder="전화번호"
                onChange={this.handleChange}
                value={this.state.phone}
            />
            <button type="submit">등록</button>
          </form>
        </div>
    );
  }
}

export default PhoneForm;